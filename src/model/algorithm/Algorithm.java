package model.algorithm;

import model.state.State;


import java.util.Stack;

public abstract class Algorithm {

    protected State initialState;
    protected State goalState;

    protected int nodeExplored;
    protected int numOfSteps;

    public Algorithm(State initialState, State goalState) {
        this.initialState = initialState;
        this.goalState = goalState;
    }

    public abstract Stack<State> solve();

    public int getNodeExplored() {
        return nodeExplored;
    }

    public int getNumOfSteps() {
        return numOfSteps;
    }

    // @Override
    // public void addSubscriber(ISubscriber listener) {
    //     this.subscriber = listener;
    // }

    // @Override
    // public void notifySubscriber(int node) {
    //     this.subscriber.update(node);
    // }
}