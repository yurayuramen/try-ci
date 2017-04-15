class CreateP7Scaffolds < ActiveRecord::Migration[5.0]
  def change
    create_table :p7_scaffolds do |t|
      t.string :name
      t.string :email
      t.date :birthday

      t.timestamps
    end
  end
end
