/*
    Copyright 2009 Semantic Discovery, Inc. (www.semanticdiscovery.com)

    This file is part of the Semantic Discovery Toolkit.

    The Semantic Discovery Toolkit is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The Semantic Discovery Toolkit is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with The Semantic Discovery Toolkit.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.sd.util.tree;


import org.sd.util.Escaper;

/**
 * A tree builder strategy for building simple trees.
 * <p>
 * @author Spence Koehler
 */
public abstract class SimpleTreeBuilderStrategy <T> implements TreeBuilderStrategy <T> {

  /**
   * Construct a non-terminal node with the given core data.
   * <p>
   * @param coreData  The core node data for the new node.
   * <p>
   * @return the new node with the given core data.
   */
  public Tree<T> constructNode(T coreData) {
    return new Tree<T>(coreData);
  }

  /**
   * Add the child as the next child of node.
   * <p>
   * @param node   The node to add the child to.
   * @param child  The child to add to the node.
   */
  public void addChild(Tree<T> node, Tree<T> child) {
    node.addChild(child);
  }

  /**
   * Build a string representation of the given tree.
   * <p>
   * @param tree The tree to build a string from.
   * @param escaper The escaper to use for the data.
   * <p>
   * @return a string representation of the given tree.
   */
  public String buildString(Tree<T> tree, Escaper escaper) {
    return tree == null ? null : tree.toString(escaper);
  }

}
