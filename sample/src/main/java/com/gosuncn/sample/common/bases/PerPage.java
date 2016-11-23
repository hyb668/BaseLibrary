package com.gosuncn.sample.common.bases;
/**
 * @author Tong
 * @time 2016/11/22
 * @apiNote
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerPage {

}
