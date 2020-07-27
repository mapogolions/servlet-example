package io.github.mapogolions.hibernatecli.onetoone.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "pull_request_details")
public class PullRequestDetails {
    @Id
    private Long id;

    @Column(name = "affected_lines")
    private int affectedLines;

    @OneToOne(mappedBy = "details")
    private PullRequest pullRequest;
}
