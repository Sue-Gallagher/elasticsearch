/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.sql.expression.function.scalar.math;

import org.elasticsearch.xpack.sql.expression.Expression;
import org.elasticsearch.xpack.sql.expression.function.scalar.math.MathProcessor.MathOperation;
import org.elasticsearch.xpack.sql.tree.Location;
import org.elasticsearch.xpack.sql.tree.NodeInfo;

/**
 * Convert from <a href="https://en.wikipedia.org/wiki/Degree_(angle)">degrees</a>
 * to <a href="https://en.wikipedia.org/wiki/Radian">radians</a>.
 */
public class Radians extends MathFunction {
    public Radians(Location location, Expression field) {
        super(location, field);
    }

    @Override
    protected NodeInfo<Radians> info() {
        return NodeInfo.create(this, Radians::new, field());
    }

    @Override
    protected Radians replaceChild(Expression newChild) {
        return new Radians(location(), newChild);
    }

    @Override
    protected String mathFunction() {
        return "toRadians";
    }

    @Override
    protected MathOperation operation() {
        return MathOperation.RADIANS;
    }
}
