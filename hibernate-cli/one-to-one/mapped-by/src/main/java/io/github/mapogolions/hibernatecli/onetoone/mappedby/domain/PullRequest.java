package io.github.mapogolions.hibernatecli.onetoone.mappedby.domain;

import javax.persistence.*;

@Entity
@Table(name = "pull_request", schema = "one_to_one")
public class PullRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne(mappedBy = "pullRequest")
    PullRequestDetails details;
}
