class CreateP8Hellos < ActiveRecord::Migration[5.0]
  def change
    create_table :p8_hellos do |t|
      t.string :name, limit: 30
      t.date :birthday
      t.text :memo
      t.string :address, limit: 100

      t.timestamps
    end
  end
end
