package com.xiaode.EasySolutions;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by xiaode on 3/24/17.
 */
public class XPathTest {

    public static void main(String[] args) {
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        File file = new File("test.xml");
        Document doc;
        DocumentBuilder builder;

        try{
            DocumentBuilderFactory factory1= DocumentBuilderFactory.newInstance();
            builder = factory1.newDocumentBuilder();
            doc = builder.parse(file);
            String result = path.evaluate("/taglib/short-name",doc);
            System.out.println(result);
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (XPathExpressionException e ) {
            e.printStackTrace();
        }



    }
}
