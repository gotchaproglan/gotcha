#!/usr/bin/env ruby
require 'fileutils'

sep = File::SEPARATOR

# Working on project root directory
FileUtils.chdir( File.expand_path( File.dirname( __FILE__ ) ) ) 
FileUtils.chdir( '..' )

# To build dir
FileUtils.chdir('build')
system("java -classpath .:../lib/antlr-3.1.1.jar Test")

