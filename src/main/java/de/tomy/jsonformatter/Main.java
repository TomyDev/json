package de.tomy.jsonformatter;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.tomy.jsonformatter.json.JsonParser;

public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws JsonProcessingException
     */
    public static void main(final String[] args) throws JsonProcessingException, InstantiationException, IllegalAccessException, IOException
    {
        //        final UserInterface uif = new UserInterface();
        //        uif.buildInterface();
        final JsonParser parser = new JsonParser(IOUtils.toInputStream("{\n" +
                "  \"Herausgeber\": \"Xema\",\n" +
                "  \"Nummer\": \"1234-5678-9012-3456\",\n" +
                "  \"Deckung\": 2e+6,\n" +
                "  \"Währung\": \"EURO\",\n" +
                "  \"Inhaber\": {\n" +
                "    \"Name\": \"Mustermann\",\n" +
                "    \"Vorname\": \"Max\",\n" +
                "    \"männlich\": true,\n" +
                "    \"Hobbys\": [ \"Reiten\", \"Golfen\", \"Lesen\" ],\n" +
                "    \"Alter\": 42,\n" +
                "    \"Kinder\": [],\n" +
                "    \"Partner\": null\n" +
                "  }\n" +
                "}"));
        parser.getRootNode();

    }
}
