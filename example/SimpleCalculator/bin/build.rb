#!/usr/bin/env ruby

require 'fileutils'

@expanded_path = File.expand_path( File.dirname( __FILE__ ) ) 

def back_to_home_dir
  FileUtils.chdir( @expanded_path ) 
end

back_to_home_dir()
eval File.read('generate.rb')

back_to_home_dir()
eval File.read('compile.rb')

