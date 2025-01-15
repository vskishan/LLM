package com.example.llm.content;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.llm.parser.JsonDocumentParser;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

@Configuration
public class SimpleContentRetriever {

    @Bean(name = "SimpleContentRetriever")
    public ContentRetriever getContent() {

        JsonDocumentParser jsonDocumentParser = new JsonDocumentParser();

        Document document = UrlDocumentLoader.load("https://gist.githubusercontent.com/emarco177/0d6a3f93dd06634d95e46a2782ed7490/raw/78233eb934aa9850b689471a604465b188e761a0/eden-marco.json", jsonDocumentParser);

        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        return EmbeddingStoreContentRetriever.from(embeddingStore);

    }
    
}
