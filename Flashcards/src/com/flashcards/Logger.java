package com.flashcards;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// only one logger for this app - singleton
public class Logger {

  private static Logger instance;
  private List<String> log;

  private Logger() {
    log = new ArrayList<>();
  }

  public static Logger getInstance() {
    if (instance == null) {
      synchronized (Logger.class) { // optional: thread safe
        if (instance == null) {
          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void logOutput(String... data) {
    for (String s : data) {
      System.out.println(s);
      this.log.add(s);
    }
  }

  public void logInput(String... data) {
    for (String s : data) {
      this.log.add(s);
    }
  }

  public void clear() {
    this.log.clear();
  }

  public boolean logToFile(File file) {
    try (FileWriter fw = new FileWriter(file, false)) { // true - append, false - overwrite
      for (String s : log) {
        fw.write(s + "\n");
      }
    } catch (IOException e) {
      System.out.println("Error: writing to file " + file.getName() + " failed");
      return false;
    }
    return true;
  }


}