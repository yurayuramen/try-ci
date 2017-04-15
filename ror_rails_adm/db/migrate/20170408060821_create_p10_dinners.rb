class CreateP10Dinners < ActiveRecord::Migration[5.0]
  def change
    create_table :p10_dinners do |t|
      t.string :title
      t.string :zensai_title
      t.text :zensai_detail
      t.string :fish_title
      t.text :fish_detail
      t.string :meat_title
      t.text :meat_detail
      t.string :main_title
      t.text :main_detail
      t.string :dessert_title
      t.text :dessert_detail

      t.timestamps
    end
  end
end
