package com.shalmezad.goap;

import java.util.Vector;

public class Action
{
    private final String name;
    private Vector<String> preconditions;
    private Vector<String> postconditions;
    private float cost;

    //region Constructors
    public Action(String name)
    {
        this.name = name;
        preconditions = new Vector<String>();
        postconditions = new Vector<String>();
        cost = 1;
    }
    //endregion

    //region Getters
    public float getCost()
    {
        return cost;
    }
    //endregion

    //region "Setters"
    public Action addPrecondition(String precondition)
    {
        this.preconditions.add(precondition);
        return this;
    }

    public Action addPostcondition(String postcondition)
    {
        this.postconditions.add(postcondition);
        return this;
    }

    public Action setCost(float cost)
    {
        this.cost = cost;
        return this;
    }
    //endregion

    public Vector<String> newState(Vector<String> oldState)
    {
        Vector<String> state = (Vector<String>) oldState.clone();
        for(String pc : postconditions)
        {
            if(pc.startsWith("!"))
            {
                state.remove(pc.substring(1));
            }
            else
            {
                state.add(pc);
            }
        }
        return state;
    }

    public boolean conditionsMet(Vector<String> state)
    {
        boolean allConditionsMet = true;
        for(String pc : preconditions)
        {
            if(pc.startsWith("!"))
            {
                allConditionsMet &= !state.contains(pc.substring(1));
            }
            else
            {
                allConditionsMet &= state.contains(pc);
            }
        }
        return allConditionsMet;
    }

    @Override
    public String toString() {
        return "<Action:" + name + ">";
    }
}
