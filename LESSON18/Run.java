package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import dom.DomCountries;
import model.Country;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import sax.CountryHandler;
import stax.StaxCountries;


public class Run
{

    private static final String COUNTRIES_XML = "Countries.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException
    {
        System.out.println(" ========================= SAX COUNTRIES parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        CountryHandler countryHandler = new CountryHandler();
        saxParser.parse(new File(COUNTRIES_XML), countryHandler);
        List<Country> countries = countryHandler.getCountries();
        countries.forEach(country -> System.out.println(country));


        System.out.println(" ============================== STAX COUNTRIES parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(COUNTRIES_XML));
        countries = new StaxCountries().parse(xmlEventReader);
        countries.forEach(country -> System.out.println(country));




        System.out.println(" ============================== DOM COUNTRIES parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(COUNTRIES_XML);
        countries = new DomCountries().parse(document);
        countries.forEach(country -> System.out.println(country));
    }

}
