package de.eisner.sorting.pipeline;

/**
 * Defines the different types of processing steps
 * that can be part of the pipeline.
 *
 * <ul>
 *     <li>INPUT – initializes input source</li>
 *     <li>READ – reads and parses raw data</li>
 *     <li>TRANSFORM – performs intermediate transformations</li>
 *     <li>SORT – sorts the processed data</li>
 *     <li>OUTPUT – writes formatted output</li>
 * </ul>
 */
public enum StepType {
    INPUT,
    READ,
    TRANSFORM,
    SORT,
    OUTPUT
}
