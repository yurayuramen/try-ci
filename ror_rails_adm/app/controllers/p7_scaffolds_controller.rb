class P7ScaffoldsController < ApplicationController
  before_action :set_p7_scaffold, only: [:show, :edit, :update, :destroy]

  # GET /p7_scaffolds
  # GET /p7_scaffolds.json
  def index
    @p7_scaffolds = P7Scaffold.all
  end

  # GET /p7_scaffolds/1
  # GET /p7_scaffolds/1.json
  def show
  end

  # GET /p7_scaffolds/new
  def new
    @p7_scaffold = P7Scaffold.new
  end

  # GET /p7_scaffolds/1/edit
  def edit
  end

  # POST /p7_scaffolds
  # POST /p7_scaffolds.json
  def create
    @p7_scaffold = P7Scaffold.new(p7_scaffold_params)

    respond_to do |format|
      if @p7_scaffold.save
        format.html { redirect_to @p7_scaffold, notice: 'P7 scaffold was successfully created.' }
        format.json { render :show, status: :created, location: @p7_scaffold }
      else
        format.html { render :new }
        format.json { render json: @p7_scaffold.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /p7_scaffolds/1
  # PATCH/PUT /p7_scaffolds/1.json
  def update
    respond_to do |format|
      if @p7_scaffold.update(p7_scaffold_params)
        format.html { redirect_to @p7_scaffold, notice: 'P7 scaffold was successfully updated.' }
        format.json { render :show, status: :ok, location: @p7_scaffold }
      else
        format.html { render :edit }
        format.json { render json: @p7_scaffold.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /p7_scaffolds/1
  # DELETE /p7_scaffolds/1.json
  def destroy
    @p7_scaffold.destroy
    respond_to do |format|
      format.html { redirect_to p7_scaffolds_url, notice: 'P7 scaffold was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_p7_scaffold
      @p7_scaffold = P7Scaffold.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def p7_scaffold_params
      params.require(:p7_scaffold).permit(:name, :email, :birthday)
    end
end
