package io.github.mapogolions.hibernatecli.onetoone.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "pull_request", schema = "onetoone")
public class PullRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "pull_request_pull_request_details_fkey"))
    PullRequestDetails details;
}
