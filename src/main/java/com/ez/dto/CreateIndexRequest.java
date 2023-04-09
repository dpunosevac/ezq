package com.ez.dto;

import javax.validation.constraints.NotNull;

/**
 * @author dpunosevac
 */
public record CreateIndexRequest(@NotNull String contentPath) {
}
