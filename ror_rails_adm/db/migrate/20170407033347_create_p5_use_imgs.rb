class CreateP5UseImgs < ActiveRecord::Migration[5.0]
  def change
    create_table :p5_use_imgs do |t|
      t.string :title
      t.text :memo
      t.string :image1
      t.string :image2
      t.timestamps
    end
  end
end
