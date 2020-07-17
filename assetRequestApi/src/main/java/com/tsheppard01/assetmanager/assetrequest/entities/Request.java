package com.tsheppard01.assetmanager.assetrequest.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "request")
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
public class Request {

  public Request(UUID id, UUID userId, RequestStatus status, Timestamp dateTimeCreated, List<RequestItem> requestItems) {
    this.id = id;
    this.userId = userId;
    this.status = status;
    this.dateTimeCreated = dateTimeCreated;
    this.requestItems = requestItems;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, columnDefinition = "request_status")
  @Type(type = "pgsql_enum")
  private RequestStatus status;

  @GeneratedValue
  @Column(name = "datetime_created", nullable = false)
  private Timestamp dateTimeCreated;

  @OneToMany(mappedBy = "request", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<RequestItem> requestItems = new ArrayList<>();

  public void addRequestItem(RequestItem item){
    requestItems.add(item);
    item.setRequest(this);
  }
}
