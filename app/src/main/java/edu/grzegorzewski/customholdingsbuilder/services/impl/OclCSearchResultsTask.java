package edu.grzegorzewski.customholdingsbuilder.services.impl;
/* ITMD-555 Android App Development
 * Dennis Grzegorzewski
 * Christopher Montufar
 * Final Project
 * Due: 12/05/2016
 */

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import edu.grzegorzewski.customholdingsbuilder.domain.Institution;

/**
 * TODO Class description.
 *
 * @author Christopher Montufar.
 * @version 1.0, 11/27/2016.
 */
public class OclCSearchResultsTask extends AsyncTask<String, Void, List<Institution>> {

    /*
     * Declare and initialize class variables
     */
    private static String state = "IL";
    private static final String OCLC_URL = "https://ill.sd00.worldcat.org/illpolicies/" + // root URL
                                           "institutionsearch?q=state:" + state + "%20AND%20supplier:Y" + // query
                                           "&wskey=vGFCwWwPUemlAApDyGfvpYrj2fR5orRXDVBrpO38RFDoHDnKlwh4bElCvfVaj8pG5KEP8HD4itDj7l4p"; // wskey
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

    /*
     * Methods.
     */

    /**
     * Override this method to perform a computation on a background thread. .
     *
     * @param params TODO description.
     * @return - TODO description.
     * @since 1.0
     */
    @Override
    protected List<Institution> doInBackground(String... params) {

        // TODO description.
        List<Institution> institutions = new ArrayList<>();

        try {

            // TODO description.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // TODO description.
            Document doc = null;

            // TODO description.
            doc = db.parse(new URL(params[0]).openStream());
            doc.getDocumentElement().normalize();

            //Integer totalSearchResults = Integer.parseInt(doc.getElementsByTagName(TOTAL_SEARCH_RESULTS).item(0).getTextContent());

            // TODO description.
            NodeList nList = doc.getElementsByTagName("entry");

            // TODO description.
            for (int index = 0; index < nList.getLength(); index++) {
                Node nNode = nList.item(index);
                Element eElement = (Element) nNode;
                if (eElement == null) {
                    continue;
                } // end if.

                // TODO description.
                Institution institution = new Institution();

                // TODO description.
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

                // TODO description.
                System.out.println("institutionName: " + institutionName);

                // TODO description.
                institution.setId(institutionId);
                institution.setName(institutionName);
                institution.setSupplier(institutionSupplier);
                institution.setDaysToRespond(institutionDaysToRespond);
                institution.setLoanDaysToRespond(institutionLoanDaysToRespond);
                institution.setCopyDaysToRespond(institutionCopyDaysToRespond);
                institution.setSymbol(institutionSymbol);
                institution.setCountry(institutionCountry);
                institution.setLocation(institutionLocation);
                institution.setLoanFees(getExtractedFeeValue(institutionLoanFees));
                institution.setCopyFees(getExtractedFeeValue(institutionCopyFees));
                institution.setSourceState(params[1]);
                institution.setTargetState(params[2]);
                institution.setZone(Integer.valueOf(params[3]));

                // TODO description.
                institutions.add(institution);
            } // end for.

        }  // end try.

        catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        } // end catch.

        return institutions;
    }

    private Float getExtractedFeeValue(String stringToExtract) {
        //Need to use Regular Expressions to extract the fee without the currency code
        String pattern = "^(\\d+\\.\\d+)(.*)";
        Pattern patternObject = Pattern.compile(pattern);

        Matcher matcher = patternObject.matcher(stringToExtract);

        if (matcher.find()) {
            return Float.valueOf(matcher.group(1));
        } else {
            return null;
        }
    }

    /**
     * Runs on the UI thread after doInBackground(Params...).
     *
     * @param institutions
     * @since 1.0
     */
    @Override
    protected void onPostExecute(List<Institution> institutions) {
        // TODO description.
    } // end method onPostExecute.

} // end class OclCSearchResultsTask.
