package org.example.States;

import java.io.IOException;

public interface StateController {
    void run() throws IOException;
    void nextState() throws IOException;
}
