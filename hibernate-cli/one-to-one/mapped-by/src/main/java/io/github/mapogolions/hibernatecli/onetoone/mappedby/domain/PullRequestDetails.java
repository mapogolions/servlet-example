package io.github.mapogolions.hibernatecli.onetoone.mappedby.domain;

import javax.persistence.*;

@Entity
@Table(name = "pull_request_details", schema = "one_to_one")
public class PullRequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "affected_lines")
    private int affectedLines;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "pull_request_details_pull_request_fkey"))
    private PullRequest pullRequest;
}
