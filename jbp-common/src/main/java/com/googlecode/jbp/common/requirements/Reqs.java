package com.googlecode.jbp.common.requirements;

/**
 * This interface provides static instances of {@code IRequirements}.
 */
public interface Reqs {
    public static final IRequirements PARAM_REQ = ParamRequirements.PARAM_REQ;
    public static final IRequirements PRE_COND = PreCondition.PRE_COND;
    public static final IRequirements POST_COND = PostCondition.POST_COND;
    public static final IRequirements GENERIC_REQ = Requirements.GENERIC_REQ;
}
