class ApplicationRecord < ActiveRecord::Base
  self.abstract_class = true
  def encoding
    Encoding::CP932
  end
end
