class CreateP2Simples < ActiveRecord::Migration[5.0]
  def change
    create_table :p2_simples do |t|
      t.string :name
      t.integer :age
      t.text :memo

      t.timestamps
    end
  end
end
