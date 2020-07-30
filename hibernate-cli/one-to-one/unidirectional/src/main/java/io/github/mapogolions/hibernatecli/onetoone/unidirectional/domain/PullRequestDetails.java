package io.github.mapogolions.hibernatecli.onetoone.unidirectional.domain;

import javax.persistence.*;

@Entity
@Table(name = "pull_request_details", schema = "one_to_one")
public class PullRequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "affected_lines")
    private int affectedLines;
}
