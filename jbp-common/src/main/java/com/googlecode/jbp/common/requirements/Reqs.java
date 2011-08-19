package com.googlecode.jbp.common.requirements;

/**
 * This interface provides static instances of {@code IRequirements}.
 */
public interface Reqs {
    public static final AbstractRequirements PARAM_REQ = ParamRequirements.PARAM_REQ;
    public static final AbstractRequirements PRE_COND = PreCondition.PRE_COND;
    public static final AbstractRequirements POST_COND = PostCondition.POST_COND;
    public static final AbstractRequirements GENERIC_REQ = Requirements.GENERIC_REQ;
}
