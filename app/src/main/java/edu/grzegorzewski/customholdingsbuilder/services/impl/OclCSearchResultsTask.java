package edu.grzegorzewski.customholdingsbuilder.services.impl;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import edu.grzegorzewski.customholdingsbuilder.domain.Institution;

/**
 * Created by Christopher Montufar on 11/27/16.
 */
public class OclCSearchResultsTask extends AsyncTask<String, Void, List<Institution>> {

    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/institutionsearch?q=state:MA%20AND%20state:OH%20AND%20supplier:Y&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p";
    private static final String TOTAL_SEARCH_RESULTS = "os:totalResults";

    private static final String OCLC_INSTITUTION_ID_ELEMENT = "ns14:institutionId";
    private static final String OCLC_INSTITUTION_NAME_ELEMENT = "ns14:name";
    private static final String OCLC_INSTITUTION_SUPPLIER_ELEMENT = "ns14:supplier";
    private static final String OCLC_INSTITUTION_DAYS_TO_RESPOND_ELEMENT = "ns14:daysToRespond";
    private static final String OCLC_INSTITUTION_LOAN_DAYS_TO_RESPOND_ELEMENT = "ns14:loanDaysToRespond";
    private static final String OCLC_INSTITUTION_COPY_DAYS_TO_RESPOND_ELEMENT = "ns14:copyDaysToRespond";
    private static final String OCLC_INSTITUTION_SYMBOL_ELEMENT = "ns14:symbol";
    private static final String OCLC_INSTITUTION_COUNTRY_ELEMENT = "ns14:country";
    private static final String OCLC_INSTITUTION_LOCATION_ELEMENT = "ns14:location";
    private static final String OCLC_INSTITUTION_LOAN_FEES_ELEMENT = "ns14:loanFees";
    private static final String OCLC_INSTITUTION_COPY_FEES_ELEMENT = "ns14:copyFees";
    private static final String OCLC_INSTITUTION_SEARCH_PARAMS_ELEMENT = "ns14:searchParams";

    @Override
    protected List<Institution> doInBackground(String... urls) {
        List<Institution> institutions = new ArrayList<>();

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = null;

            doc = db.parse(new URL(urls[0]).openStream());
            doc.getDocumentElement().normalize();

            //Integer totalSearchResults = Integer.parseInt(doc.getElementsByTagName(TOTAL_SEARCH_RESULTS).item(0).getTextContent());

            NodeList nList = doc.getElementsByTagName("entry");

            for (int index = 0; index < nList.getLength(); index++) {
                Node nNode = nList.item(index);
                Element eElement = (Element) nNode;
                if (eElement == null) {
                    continue;
                }

                Institution institution = new Institution();

                String institutionId = eElement.getElementsByTagName(OCLC_INSTITUTION_ID_ELEMENT).item(0).getTextContent();
                String institutionName = eElement.getElementsByTagName(OCLC_INSTITUTION_NAME_ELEMENT).item(0).getTextContent();
                String institutionSupplier = eElement.getElementsByTagName(OCLC_INSTITUTION_SUPPLIER_ELEMENT).item(0).getTextContent();
                String institutionDaysToRespond = eElement.getElementsByTagName(OCLC_INSTITUTION_DAYS_TO_RESPOND_ELEMENT).item(0).getTextContent();
                String institutionLoanDaysToRespond = eElement.getElementsByTagName(OCLC_INSTITUTION_LOAN_DAYS_TO_RESPOND_ELEMENT).item(0).getTextContent();
                String institutionCopyDaysToRespond = eElement.getElementsByTagName(OCLC_INSTITUTION_COPY_DAYS_TO_RESPOND_ELEMENT).item(0).getTextContent();
                String institutionSymbol = eElement.getElementsByTagName(OCLC_INSTITUTION_SYMBOL_ELEMENT).item(0).getTextContent();
                String institutionCountry = eElement.getElementsByTagName(OCLC_INSTITUTION_COUNTRY_ELEMENT).item(0).getTextContent();
                String institutionLocation = eElement.getElementsByTagName(OCLC_INSTITUTION_LOCATION_ELEMENT).item(0).getTextContent();
                String institutionLoanFees = eElement.getElementsByTagName(OCLC_INSTITUTION_LOAN_FEES_ELEMENT).item(0).getTextContent();
                String institutionCopyFees = eElement.getElementsByTagName(OCLC_INSTITUTION_COPY_FEES_ELEMENT).item(0).getTextContent();
                String institutionSearchParams = eElement.getElementsByTagName(OCLC_INSTITUTION_SEARCH_PARAMS_ELEMENT).item(0).getTextContent();

                System.out.println("institutionName: " + institutionName);

                institution.setId(institutionId);
                institution.setName(institutionName);
                institution.setSupplier(institutionSupplier);
                institution.setDaysToRespond(institutionDaysToRespond);
                institution.setLoanDaysToRespond(institutionLoanDaysToRespond);
                institution.setCopyDaysToRespond(institutionCopyDaysToRespond);
                institution.setSymbol(institutionSymbol);
                institution.setCountry(institutionCountry);
                institution.setLocation(institutionLocation);
                institution.setLoanFees(institutionLoanFees);
                institution.setCopyFees(institutionCopyFees);
                institution.setSearchParams(institutionSearchParams);

                institutions.add(institution);
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return institutions;
    }

    @Override
    protected void onPostExecute(List<Institution> institutions) {

    }
}
