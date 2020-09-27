package com.dinitha.testapp.utilities;

import com.dinitha.testapp.rest.CustomerController;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SemanticAPI {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    public SemanticAPIResponse semanticAnalysis(String comment) throws Exception {

        SemanticAPIResponse semanticAPIResponse = new SemanticAPIResponse();
        // Instantiates a client
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            // The text to analyze
            Document doc = Document.newBuilder().setContent(comment).setType(Document.Type.PLAIN_TEXT).build();

            // Detects the sentiment of the text
            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
            if(sentiment != null){
                semanticAPIResponse.setMagnitude(sentiment.getMagnitude());
                semanticAPIResponse.setScore(sentiment.getScore());
            }
        }
        return  semanticAPIResponse;
    }

}
