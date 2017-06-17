class AddGcsToP5UseImg < ActiveRecord::Migration[5.0]
  def change
    add_column :p5_use_imgs, :gcs, :string
  end
end
