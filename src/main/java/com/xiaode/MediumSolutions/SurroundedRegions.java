package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jul, 2019
 *
 * 130. Surrounded Regions
 *
 *
 */
public class SurroundedRegions {
    // My original DFS method, forget to consider the post case
    // Better to use Union Find
    boolean [][] visited;
    int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int x = board.length;
        int y = board[0].length;
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if( !visited[i][j] && board[i][j] == 'O') {
                    dfs(board, i, j, x, y);
                }
            }
        }
    }

    private char dfs(char[][] board, int x, int y, int c, int r) {
        visited[x][y] = true;
        if(x == 0 || x == c-1 || y == 0 || y == r-1) return 'O';
        board[x][y] = 'X';
        for(int[] dir : dirs) {
            if(board[x+dir[0]][y+dir[1]] == 'O' && !visited[x+dir[0]][y+dir[1]]) {
                board[x][y] = dfs(board, x+dir[0], y+dir[1], c, r);
            }
        }

        return board[x][y];
    }

    // better DFS
    public void solve3(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        boolean[][] seen = new boolean[board.length][board[0].length];
        int m = board.length, n = board[0].length;
        //先检查边界
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(board, i, 0, seen);
            if(board[i][n-1] == 'O') dfs(board, i, n-1, seen);
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O') dfs(board, 0, i, seen);
            if(board[m-1][i] == 'O') dfs(board, m-1, i, seen);
        }
        // 再flip没有visited的O
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !seen[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] seen){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j] || board[i][j] == 'X') return;
        seen[i][j] = true;
        dfs(board, i+1, j, seen);
        dfs(board, i-1, j, seen);
        dfs(board, i, j+1, seen);
        dfs(board, i, j-1, seen);
    }


    //Union Find
    int rows, cols;

    public void solve2(char[][] board) {
        if(board == null || board.length == 0) return;

        rows = board.length;
        cols = board[0].length;

        // last one is dummy, all outer O are connected to this dummy
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == rows-1 || j == 0 || j == cols-1) {
                        uf.union(node(i,j), dummyNode);
                    }
                    else {
                        if(i > 0 && board[i-1][j] == 'O')  uf.union(node(i,j), node(i-1,j));
                        if(i < rows-1 && board[i+1][j] == 'O')  uf.union(node(i,j), node(i+1,j));
                        if(j > 0 && board[i][j-1] == 'O')  uf.union(node(i,j), node(i, j-1));
                        if(j < cols-1 && board[i][j+1] == 'O')  uf.union(node(i,j), node(i, j+1));
                    }
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(uf.isConnected(node(i,j), dummyNode)) {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return i * cols + j;
    }
}

class UnionFind {
    int [] parents;
    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for(int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while(parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
