class CreateP21Users < ActiveRecord::Migration[5.0]
  def change
    create_table :p21_users do |t|
      t.string :name
      t.text :memo
      t.date :birthday

      t.timestamps
    end
  end
end
