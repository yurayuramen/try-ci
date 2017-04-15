class P6User < ApplicationRecord
  has_and_belongs_to_many :p6_group 
end
