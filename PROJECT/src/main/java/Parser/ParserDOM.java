package Parser;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParserDOM {
    public String parserSearch(int index, String tag) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File("MessageFriendParse.xml"));
        NodeList nodeList = doc.getElementsByTagName("Friend");
        Element element = (Element)nodeList.item(index);
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}
