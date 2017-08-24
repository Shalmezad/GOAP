package com.shalmezad.goap;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<String> currentState = new Vector<String>();
        Vector<Action> possibleActions = new Vector<Action>();
        String goal;

        // Set up our current state:

        // Set up our actions:
        Action actionGrabBall = new Action("GRAB BALL");
        actionGrabBall.addPrecondition("AT BALL");
        actionGrabBall.addPostcondition("HAVE BALL");
        possibleActions.add(actionGrabBall);

        Action actionGotoGoal = new Action("GOTO GOAL");
        actionGotoGoal.addPrecondition("!AT GOAL");
        actionGotoGoal.addPostcondition("AT GOAL");
        actionGotoGoal.addPostcondition("!AT BALL");
        possibleActions.add(actionGotoGoal);

        Action actionGotoBall = new Action("GOTO BALL");
        actionGotoBall.addPrecondition("!AT BALL");
        actionGotoBall.addPostcondition("AT BALL");
        actionGotoBall.addPostcondition("!AT GOAL");
        possibleActions.add(actionGotoBall);

        Action actionScore = new Action("SCORE");
        actionScore.addPrecondition("HAVE BALL");
        actionScore.addPrecondition("AT GOAL");
        actionScore.addPostcondition("SCORED GOAL");
        possibleActions.add(actionScore);

        // Set up our goal:
        goal = "SCORED GOAL";

        Plan plan = Goap.planActions(currentState, possibleActions, goal);
        System.out.println(plan);

    }
}
