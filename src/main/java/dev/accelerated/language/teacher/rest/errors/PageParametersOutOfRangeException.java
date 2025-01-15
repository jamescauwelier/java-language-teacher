package dev.accelerated.language.teacher.rest.errors;

public class PageParametersOutOfRangeException extends RuntimeException {
    public PageParametersOutOfRangeException(int pageRequested, int pagesAvailable) {
        super(String.format("Page %d was requested, but only %d are available", pageRequested, pagesAvailable));
    }
}
