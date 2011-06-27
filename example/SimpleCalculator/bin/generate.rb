#!/usr/bin/env ruby
require 'fileutils'

output_dir = 'output'
grammar_dir = 'grammar'
sep = File::SEPARATOR

# Working on project root directory
FileUtils.chdir( File.expand_path( File.dirname( __FILE__ ) ) ) 
FileUtils.chdir( '..' )

# Recreate output directory
FileUtils.rm_rf( output_dir )
FileUtils.mkdir( output_dir )

# Working on output directory
FileUtils.chdir( output_dir )

puts File.expand_path("..#{sep}" + grammar_dir) + "#{sep}*.g"

# Generate lexer and parser
FileUtils.cp( Dir.glob( File.expand_path("..#{sep}" + grammar_dir) + "#{sep}*.g" ), "." )
puts Dir.pwd
system("java -classpath ..#{sep}lib#{sep}antlr-3.1.1.jar org.antlr.Tool " + Dir.glob('*.g').join(' '))

# Remove all temp files
FileUtils.rm Dir.glob('*.g')

