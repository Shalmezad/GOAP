package com.shalmezad.goap;

import java.util.Vector;

public class Plan
{
    public Vector<String> lastState;
    public float cost;
    public Vector<Action> actions;

    public Plan()
    {
        lastState = new Vector<String>();
        cost = 0;
        actions = new Vector<Action>();
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += "[";
        for(Action action : actions)
        {
            returnString += action.toString();
            returnString += ",";
        }
        returnString += "]";
        return  returnString;
    }
}
