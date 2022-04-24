package com.announcement.test.domain.search;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "search_announcement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAnnouncement implements Serializable {

  @Id
  private String id;
  private String title;
  private JsonNode attribute;
}
