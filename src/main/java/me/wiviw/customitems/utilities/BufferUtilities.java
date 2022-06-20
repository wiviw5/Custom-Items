package me.wiviw.customitems.utilities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

public class BufferUtilities {

    // TODO Setup Making new and accessing old buffers via SQL.
    private static TextComponent.Builder bufferComponent = Component.empty().toBuilder();

    public static Component getBuffer(String name){
        return bufferComponent.build();
    }

    public static Component addToBuffer(String name, Component component){
        return bufferComponent.append(component).build();
    }

    public static void newBuffer(String name, Component component){
        bufferComponent = Component.empty().toBuilder();
        bufferComponent.append(component);
    }

    public static void setBuffer(String name, Component component){

    }
}
