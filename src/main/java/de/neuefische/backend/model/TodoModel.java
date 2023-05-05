package de.neuefische.backend.model;

import lombok.Data;

@Data
public class TodoModel {
    String id;
    String description;
    slugStatusEnum status;
}
