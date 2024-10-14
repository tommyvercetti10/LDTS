package org.example.Model.Spawner;

import org.example.Model.Creator.Creator;
import org.example.Model.Elements.Element;

import java.util.List;

public class Spawner {
    private List<Element> elements;
    public Spawner(List<Element> elements) {
        this.elements = elements;
    }
    public void spawn(Creator creator, long time, int number) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    for (int i = 0; i < number; i++) {
                        Element element = creator.create();
                        elements.add(element);
                    }
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex){
                        System.err.println(ex);
                    }
                }
            }
        }).start();
    }
}
