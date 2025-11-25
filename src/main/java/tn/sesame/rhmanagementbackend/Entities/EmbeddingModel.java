package tn.sesame.rhmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.InitialContext;
import java.util.UUID;
import java.util.Vector;

@Entity
@Table(name = "embedding_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmbeddingModel {

    @Id
    @GeneratedValue
    private UUID id;

    private String content;
    private String source;
    private String metadata;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private HRDocument document;

    Vector<Object> embedding = new Vector<>(1536);

    //private float[] embedding;


}
