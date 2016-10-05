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
package org.sd.util;

public class CommandLine {
  StringBuffer usage;
  int argMin;
  int argMax;
  
  public CommandLine( Class theClass, String[] args ) {
    this( theClass, args, null );
  }

  public CommandLine( Class theClass, String[] args, String[] optionalArgs ) {
    usage = new StringBuffer("\nUSAGE:\n\tjava " + theClass.getName());
    argMin = 0;
    
    for ( String arg: args ) {
      usage.append( " <" + arg + ">" );
      argMin++;
    }
    
    argMax = argMin;
    
    if ( optionalArgs != null ) {
      for ( String arg: optionalArgs ) {
        usage.append( " [" + arg + "]" );
        argMax++;
      }
    }
    
    usage.append("\n");
  }

  public String getUsage() {
    return usage.toString();
  }

  public boolean isValid( String[] args ) {
    if ( args.length >= argMin && args.length <= argMax ) {
      return true;
    }
    return false;
  }
}
