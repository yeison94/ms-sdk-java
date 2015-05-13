package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.WorkflowConfig;
import com.viafirma.mobile.services.sdk.java.model.Task;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TaskManager  {
  
  private List<Task> tasks = new ArrayList<Task>() ;
  private List<WorkflowConfig> workflows = new ArrayList<WorkflowConfig>() ;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("tasks")
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("workflows")
  public List<WorkflowConfig> getWorkflows() {
    return workflows;
  }
  public void setWorkflows(List<WorkflowConfig> workflows) {
    this.workflows = workflows;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskManager {\n");
    
    sb.append("  tasks: ").append(tasks).append("\n");
    sb.append("  workflows: ").append(workflows).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
