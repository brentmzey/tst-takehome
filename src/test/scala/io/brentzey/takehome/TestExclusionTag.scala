package io.brentzey.takehome

import org.scalatest.Tag

/**
 * Provides a tag for the tests you may need to exclude
 * say for example test classes written that would touch a paid API endpoint
 */
object TestExclusionTag extends Tag("io.brentzey.takehome.TestExclusionTag"){}
