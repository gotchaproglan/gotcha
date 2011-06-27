#!/usr/bin/env ruby
require 'fileutils'

sep = File::SEPARATOR

# Working on project root directory
FileUtils.chdir( File.expand_path( File.dirname( __FILE__ ) ) ) 
FileUtils.chdir( '..' )

# Recreate build directory
FileUtils.rm_rf( 'build' )
FileUtils.mkdir( 'build' )

# Compile lexer, paser and tests
system("javac -verbose -classpath lib#{sep}antlr-3.1.1.jar output#{sep}*.java -d build")
system("javac -verbose -classpath lib#{sep}antlr-3.1.1.jar:output#{sep} test#{sep}*.java -d build")

