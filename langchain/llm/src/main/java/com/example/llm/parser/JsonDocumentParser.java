package com.example.llm.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * Custom JSON Document Parser that converts a JSON string into Langchain4J
 * Document.
 */
public class JsonDocumentParser implements DocumentParser {

    private static final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper for JSON parsing

    /**
     * Parses the raw JSON content from an InputStream into a Document
     * containing TextSegments.
     *
     * @param inputStream The InputStream containing raw JSON content.
     * @return The parsed Document containing TextSegments.
     * @throws IOException If an error occurs during JSON parsing.
     */
    @Override
    public Document parse(InputStream inputStream) {
        try {
            return parseJson(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return new Document("Error parsing JSON content: " + e.getMessage());
        }

    }

    private Document parseJson(InputStream inputStream) throws IOException {
        // Parse the InputStream into a JsonNode (root of the JSON tree)
        JsonNode rootNode = objectMapper.readTree(inputStream);

        // Initialize a StringBuilder to hold the concatenated text
        StringBuilder documentText = new StringBuilder();

        // Extract the "full_name" and "occupation"
        String fullName = rootNode.path("full_name").asText("Unknown");
        String occupation = rootNode.path("occupation").asText("Unknown");
        String headline = rootNode.path("headline").asText("No headline available");

        documentText.append("Name: ").append(fullName).append("\n");
        documentText.append("Occupation: ").append(occupation).append("\n");
        documentText.append("Headline: ").append(headline).append("\n");

        // Extract the "summary"
        String summary = rootNode.path("summary").asText("No summary available");
        documentText.append("Summary: ").append(summary).append("\n");

        // Extract the "experiences" array and add each experience as a text block
        if (rootNode.has("experiences")) {
            JsonNode experiences = rootNode.get("experiences");
            for (JsonNode experience : experiences) {
                String company = experience.path("company").asText("Unknown");
                String title = experience.path("title").asText("Unknown Title");
                String location = experience.path("location").asText("Unknown Location");
                String description = experience.path("description").asText("No description available");

                documentText.append("Experience at ").append(company)
                        .append(" (").append(title).append("), Location: ").append(location)
                        .append(". Description: ").append(description).append("\n");
            }
        }

        // Return a Document containing the concatenated text
        return new Document(documentText.toString());
    }
}
