class P4Parent < ApplicationRecord
  has_many :p4_children ,through: :p4_assigns
  has_many :p4_assigns

end
=begin
RailsAdmin.config do |config|
  config.model 'P4Parent' do
    list do
      field :title
      field :pre
      field :p4_children do |child|
        child.name
      end
    end
  end
end
=end