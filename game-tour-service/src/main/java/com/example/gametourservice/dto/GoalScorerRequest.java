package com.example.gametourservice.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoalScorerRequest {

    boolean goal1;

    boolean goal2;

    String goalscorer1;

    String goalscorer2;

    String assistant1;

    String assistant2;
}
